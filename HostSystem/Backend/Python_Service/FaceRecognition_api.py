from flask import Flask, request, jsonify
import cv2
import dlib
import numpy as np

app = Flask(__name__)

PATH_model_predictor_68_face_landmark = \
    "../../../../../Project Silver/BIGC_FaceRecognition/model/face_recognition_resnet_model.dat"

PATH_model_face_recognition_resnet_model = \
    "../../../../../Project Silver/BIGC_FaceRecognition/model/shape_predictor_68_face_landmarks.dat"


global face_descriptor


def get_face_landmarks_128vectors_from_img(img):
    global face_descriptor
    b, g, r = cv2.split(img)
    img2 = cv2.merge([r, g, b])
    detector = dlib.get_frontal_face_detector()
    shape_predictor = dlib.shape_predictor(PATH_model_face_recognition_resnet_model)
    face_rec_model = dlib.face_recognition_model_v1(PATH_model_predictor_68_face_landmark)
    dets = detector(img, 1)  # 人脸标定
    for index, face in enumerate(dets):
        shape = shape_predictor(img2, face)  # 提取68个特征点
        face_descriptor = face_rec_model.compute_face_descriptor(img2, shape)  # 计算人脸的128维的向量
        face_descriptor = np.array(face_descriptor)

    return face_descriptor.reshape(1, 128).tolist()


@app.route('/get_face_descriptor', methods=['POST'])
def get_face_descriptor():
    print(request.files)
    if 'file' not in request.files:
        return jsonify({'error': 'No file part'})

    file = request.files['file']

    if file.filename == '':
        return jsonify({'error': 'No selected file'})

    try:
        image_data = file.read()
        nparr = np.frombuffer(image_data, np.uint8)
        img = cv2.imdecode(nparr, cv2.IMREAD_COLOR)
        face_descriptor = get_face_landmarks_128vectors_from_img(img)
        return jsonify({'success': True, 'face_descriptor': face_descriptor})
    except Exception as e:
        return jsonify({'error': str(e)})


if __name__ == '__main__':
    app.run(debug=False, port=5001)
