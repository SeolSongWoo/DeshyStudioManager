import Fetch from "../Fetch.js";

export default class ProductServerRequest extends Fetch {
    constructor() {
        super('/api/products');
    }

    async createProduct(body) {
        return await this.fetch({
            httpMethod: 'POST',
            body: body,
        });
    }

    async createCategory(body) {
        return await this.fetch({
            httpMethod: 'POST',
            body: body,
        })
    }
}