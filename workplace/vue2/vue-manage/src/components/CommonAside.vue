<template>
    <el-menu
        default-active="1-4-1"
        class="el-menu-vertical-demo"
        @open="handleOpen"
        @close="handleClose"
        :collapse="isCollapse"
        background-color="#545c64"
        text-color="#fff"
        active-text-color="#ffd04b"
    >
    <!-- 一级菜单部分 -->
        <h3>{{isCollapse?'后台':'通用管理系统'}}</h3>
        <el-menu-item @click="clickMenu(item)" v-for="item in noChildren" :index="item.path" :key="item.path">
            <i :class="`el-icon-`+item.icon"></i>
            <span slot="title">{{item.label}}</span>
        </el-menu-item>

      <!-- 二级菜单部分 -->
        <el-submenu v-for="item in hasChildren" :index="item.path" :key="item.path">
            <template slot="title">
                <i :class="`el-icon-`+item.icon"></i>
                <span slot="title">{{item.label}}</span>
            </template>
            <el-menu-item-group v-for="(subItem,subIndex) in item.children" :key="subItem.path">
                <el-menu-item :index="subIndex">{{subItem.label}}</el-menu-item>
            </el-menu-item-group>
        </el-submenu>
    </el-menu>
</template>



<style lang="less" scoped>
.el-menu-vertical-demo:not(.el-menu--collapse) {
    width: 200px;
    min-height: 400px;
}            
.el-menu{
    height: 100%;
    border: none;
    h3{
    color: #fff;
    text-align: center;
    line-height: 48px;
}
}

</style>
<script>
export default {
    name: "CommonAside",
    data() {
        return {
            // 控制是否展开 为false的话就是展开
            // isCollapse: false,
            menu:[
                {
                    path: "/",
                    name: "home",
                    label: "首页",
                    icon: "s-home",
                    url: "home/index",
                },
                {
                    path: "/mall",
                    name: "mall",
                    label: "商品管理",
                    icon: "video-play",
                    url: "mall/index.vue",
                },
                {
                    path: "/user",
                    name: "user",
                    label: "用户管理",
                    icon: "user",
                    url: "User/index",
                },
                {
                    label: "其他",
                    icon: "location",
                    children: [
                        {
                            path: "/page1",
                            name: "page1",
                            label: "页面1",
                            icon: "setting",
                            url: "Other/PageOne.vue",
                        },
                        {
                            path: "/page2",
                            name: "page2",
                            label: "页面2",
                            icon: "setting",
                            url: "Other/PageTwo.vue",
                        },
                    ],
                },
            ],
        };
    },
    methods: {
        handleOpen(key, keyPath) {
            console.log(key, keyPath);
        },
        handleClose(key, keyPath) {
            console.log(key, keyPath);
        },
        clickMenu(item){
            this.$router.push({
                name:item.name
            })
        }
    },
    computed:{
        noChildren(){
           return  this.menu.filter(item=>!item.children);
        },
        hasChildren(){
            return this.menu.filter(item=>item.children);
        },
        isCollapse(){
            return this.$store.state.tab.isCollapse
        }
    }
};
</script>