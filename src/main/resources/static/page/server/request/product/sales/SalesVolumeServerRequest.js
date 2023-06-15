import Fetch from "../../Fetch.js";

export default class SalesVolumeServerRequest extends Fetch{
    constructor() {
        super('/api/products/sales/volume');
    }

    async getTotalSalesVolume() {
        return await this.fetch({
            httpMethod: 'POST',
        });
    }

    async getTodaySalesVolume() {
        return await this.fetch({
            url: '/today',
            httpMethod: 'POST',
        });
    }

    async getThisMonthSalesVolume() {
        return await this.fetch({
            url: '/month',
            httpMethod: 'POST',
        });
    }

    async getThisYearSalesVolume() {
        return await this.fetch({
            url: '/year',
            httpMethod: 'POST',
        });
    }
}