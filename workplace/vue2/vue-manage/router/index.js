import Vue from 'vue'
import VueRouter from 'vue-router'

// import Home from '../views/Home.vue'

const routes = [
    {
        path:'/',
        name:'Main',
        component:()=>import('../views/Main.vue'),
        children:[
            {
                path:'/home',
                name:'home',
                component:()=>import('../views/home')
            },
            {
                path:'/user',
                name:'user',
                component:()=>import('../views/User')
            },
        ]
    },
]

Vue.use(VueRouter)

const router1 =  new VueRouter({
    mode:'history',
    routes
})

export default router1