import Fetch from "../../Fetch.js";

export default class SalesVolumeServerRequest extends Fetch{
    constructor() {
        super('/api/products/sales/volume');
    }

    async getTotalSalesVolume() {
        return await this.fetch({
            httpMethod: 'GET',
        });
    }

    async getTodaySalesVolume() {
        return await this.fetch({
            url: '/today',
            httpMethod: 'GET',
        });
    }

    async getTodaySalesVolumeByHour() {
        return await this.fetch({
            url: '/today/hour',
            httpMethod: 'GET',
        });
    }

    async getThisMonthSalesVolume() {
        return await this.fetch({
            url: '/month',
            httpMethod: 'GET',
        });
    }

    async getThisMonthSalesVolumeByHour() {
        return await this.fetch({
            url: '/month/hour',
            httpMethod: 'GET',
        });
    }

    async getThisYearSalesVolume() {
        return await this.fetch({
            url: '/year',
            httpMethod: 'GET',
        });
    }

    async getThisYearSalesByHour() {
        return await this.fetch({
            url: '/year/hour',
            httpMethod: 'GET',
        });
    }
}