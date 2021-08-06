<template>
  <div class="container outer" >
    <h3 class="text-center mt-3">Your shopping cart</h3>
    <table class="table table-borderless mt-5">
      <thead class="text-center">
        <tr>
          <th class="col-2">Image</th>
          <th class="col-2">Product Name</th>
          <th class="col-4">Quantity</th>
          <th class="col-2">Unit price</th>
          <th class="col-2">Total</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="product in products" :key="product.id" class="text-center">
          <td class="col-2">
            <img
              :src="require(`../assets/watch${product.id}.jpg`)"
              class="img"
              
            />
          </td>
          <td class="col-2 align-middle">{{ product.name }}</td>
          <td class="col-4 align-middle">
            <span>{{ product.quantity }}</span> &nbsp;
            <button
              type="button"
              class="btn btn-sm btn-primary"
              @click="product.quantity += 1"
            >
              <i class="fas fa-plus fa-xs"></i>
            </button>
            <button
              type="button"
              class="btn btn-sm btn-danger"
              @click="product.quantity > 1 ? (product.quantity -= 1) : null"
            >
              <i class="fas fa-minus fa-xs"></i>
            </button>
          </td>
          <td class="col-2 align-middle">${{ product.price }}</td>
          <td class="col-2 align-middle">
            ${{ product.price * product.quantity }}
          </td>
        </tr>
        <tr>
          <td class="col-2"></td>
          <td class="col-2"></td>
          <td class="col-4"></td>
          <td class="col-4" colspan="4">
            <form class="form-inline" @submit.prevent="handleSubmit">
              <div class="form-group mx-sm-1 mb-2">
                <input
                  type="text"
                  class="form-control"
                  placeholder="Your code"
                  v-model="code"
                />
              </div>
              <button class="btn btn-primary mb-2" type="submit">Apply</button>
            </form>
          </td>
        </tr>
        <tr class="text-center">
          <td class="col-2"></td>
          <td class="col-2"></td>
          <td class="col-4"></td>
          <td class="col-2">Subtotal</td>
          <td class="col-2">${{ subTotal }}</td>
        </tr>
        <tr class="text-center">
          <td class="col-2"></td>
          <td class="col-2"></td>
          <td class="col-4"></td>
          <td class="col-2">Total</td>
          <td class="col-2">${{ total }}</td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import axios from "axios";
export default {
  name: "Cart",
  data() {
    return {
      products: [],
      code: "",
      discount: 0,
    };
  },
  methods: {
    handleSubmit() {
      switch (this.code) {
        case "acer":
          this.discount = 0.05;
          break;
        case "moon":
          this.discount = 0.1;
          break;
        default:
      }
    },
  },
  computed: {
    subTotal() {
      let total = 0;
      this.products.map((product) => {
        total += product.quantity * product.price;
      });
      return total;
    },
    total(){
        let discount = this.subTotal*this.discount
        let net = this.subTotal - discount;
        let tax = net *0.1
        return Math.round((net+tax+Number.EPSILON)*100)/100
    }
  },
  async created() {
    let items = [];
    const products = [];
    await axios.get("http://localhost:4000/products").then((res) => {
      items = res.data;
    });

    items.forEach((item) => {
      let product = { ...item, quantity: 1 };
      products.push(product);
    });
    this.products = products;
  },
};
</script>

<style scoped>
.outer{
    font-size:20px;
    background:#343a40;
    color:aliceblue;
}
.table-borderless td,
.table-borderless th {
    border: 0;
}
.img{
    width:100px;
    height:100px;
    border-radius:50%;
    transition: ease-in-out;
}
.img:hover{
    transform: scale(1.2);
}

</style>
