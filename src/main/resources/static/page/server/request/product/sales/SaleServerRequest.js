import Fetch from "../../Fetch.js";

export default class SaleServerRequest extends Fetch{
    constructor() {
        super('/api/products/sales');
    }

    async getAllSaleByPaging(startPage,endPage) {
        return await this.fetch({
            url: `/${startPage}/to/${endPage}`,
            httpMethod: 'GET',
        });
    }
}