import Home from "./components/Home.vue";
import Cart from "./components/Cart.vue";
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
    component: Cart,
  },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});
export default router;
