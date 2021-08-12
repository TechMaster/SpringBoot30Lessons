import Home from "./components/Home.vue";
// import Cart from "./components/Cart.vue";
import Cart2 from "./components/Cart2.vue"
import {createRouter,createWebHistory} from 'vue-router'
const routes = [
  {
    name: "home",
    path: "/",
    component: Home,
  },
  {
    name: "cart",
    path: "/cart",
    component: Cart2,
  },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});
export default router;
