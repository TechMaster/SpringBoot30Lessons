<template>
<div class="container outer">
    <div class="d-flex mt-3 justify-content-center">
        <router-link to="/" class="align-self-center ">
            <i class="fas fa-long-arrow-alt-left"></i>
        </router-link>
        
        <h3 class="align-self-center mx-2">Your shopping cart</h3>
    </div>
    
    <table class="table table-borderless mt-5 table-dark">
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
            <tr v-for="order in cart.orderList" :key="order.product.id" class="text-center">
                <td class="col-2">
                    <img :src="require(`../assets/watch${order.product.id}.jpg`)" class="img" />
                </td>
                <td class="col-2 align-middle">{{ order.product.name }}</td>
                <td class="col-4 align-middle">
                    <span>{{ order.count }}</span> &nbsp;
                    <button type="button" class="btn btn-sm btn-primary" @click="addToCart(order.product.id)">
                        <i class="fas fa-plus fa-xs"></i>
                    </button>
                    <button type="button" class="btn btn-sm btn-danger"
                            @click="remove(order.product.id)">
                        <i class="fas fa-minus fa-xs"></i>
                    </button>
                    <button type="button" class="btn btn-sm" style="color:red;"
                            @click="removeOrder(order.product.id)">
                        <i class="fas fa-minus-circle"></i>
                    </button>
                </td>
                <td class="col-2 align-middle">${{ order.product.price }}</td>
                <td class="col-2 align-middle">
                    ${{ order.product.price * order.count }}
                </td>
            </tr>
            <tr>
                <td class="col-2"></td>
                <td class="col-2"></td>
                <td class="col-4"></td>
                <td class="col-4" colspan="4">
                    <form class="form-inline" @submit.prevent="handleSubmit">
                        <div class="form-group mx-sm-1 mb-2">
                            <input type="text" class="form-control" placeholder="Your code" v-model="code" />
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
                <td class="col-2">${{cart.rawTotal }}</td>
            </tr>
            <tr class="text-center">
                <td class="col-2"></td>
                <td class="col-2"></td>
                <td class="col-4"></td>
                <td class="col-2">Discount</td>
                <td class="col-2">${{cart.discount }}</td>
            </tr>
            <tr class="text-center">
                <td class="col-2"></td>
                <td class="col-2"></td>
                <td class="col-4"></td>
                <td class="col-2">VAT</td>
                <td class="col-2">${{cart.vatTax }}</td>
            </tr>
            <tr class="text-center">
                <td class="col-2"></td>
                <td class="col-2"></td>
                <td class="col-4"></td>
                <td class="col-2">Total</td>
                <td class="col-2">${{ cart.total }}</td>
            </tr>
        </tbody>
    </table>
</div>
</template>

<script>
import axios from 'axios'
export default {
    name:"Cart2",
    data(){
        return{
            cart:{},
            code:""
        }
    },
    methods:{
        async addToCart(id){
            await axios.get(`http://localhost:8100/api/add/${id}`)
                .then(res=>{
                    this.cart = res.data;
                })
        },
        async remove(id){
            await axios.get(`http://localhost:8100/api/remove/${id}`)
            .then(res=>{
                this.cart = res.data;
            })
        },
        async removeOrder(id){
            await axios.get(`http://localhost:8100/api/delete/${id}`)
            .then(res=>{
                this.cart = res.data;
                
            })
        },
        async handleSubmit(){
            await axios.post(`http://localhost:8100/api/discount/${this.code}`)
            .then(res=>{
                this.cart = res.data;
                this.code =""
            })
        }
    },
    async created(){
        await axios.get("http://localhost:8100/api/cart")
            .then(res=>{
                this.cart = res.data
            })
        
    }
}
</script>

<style scoped>
.outer{
    font-size:20px;
    background:#343a40;
    color:white;
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



