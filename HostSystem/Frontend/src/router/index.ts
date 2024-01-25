import { createRouter, createWebHistory } from 'vue-router'

export default createRouter({
    history: createWebHistory(),
    routes: [
        {
            // 主页
            path: "/",
            name: "Index",
            component: () => import("@/views/index.vue"),
            children:[
                {
                    // 用户
                    path: "user",
                    name: "User",
                    component: () => import("@/views/user/index.vue"),
                },
                {
                    // 用户
                    path: "face",
                    name: "Face",
                    component: () => import("@/views/face/index.vue"),
                },
                {
                    // 废料桶
                    path: "wasteBin",
                    name: "WasteBin",
                    component: () => import("@/views/wasteBin/index.vue"),
                }
            ]
        },
        {
            // 主页
            path: "/login",
            name: "Login",
            component: () => import("@/views/admin/login.vue"),
        },
        
    ]
})