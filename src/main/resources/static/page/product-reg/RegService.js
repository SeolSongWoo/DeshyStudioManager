import ProductServerRequest from "../server/request/product/ProductServerRequest.js";

export default class ProductRegService {
    constructor() {
        this.productServerRequest = new ProductServerRequest();
    }

    async createProduct(body) {
        return await this.productServerRequest.createProduct(body);
    }

    async createCategory(body) {
        return await this.productServerRequest.createCategory(body);
    }
}