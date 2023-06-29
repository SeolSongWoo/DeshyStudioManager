export default class Util {
    static formatPrice(price) {
        return new Intl.NumberFormat('ko-KR', { style: 'currency', currency: 'KRW' }).format(price);
    }

    static formatDate(stringDate) {
        return stringDate.replace('T',' ');
    }

    static fillMissingData(originalData, dates,salesMetricsName) {
        originalData = originalData || [];
        return dates.map(date => {
            const foundData = originalData.find(item => {
                const itemDate = new Date(item.salesDate);
                const dateDate = new Date(date);
                return itemDate.getTime() === dateDate.getTime();
            });
            return foundData ? foundData[salesMetricsName] : 0;
        });
    }

    static checkValidity(event) {
        if (!event.target.checkValidity()) {
            event.stopPropagation();
            event.target.classList.add('was-validated');
            return false;
        }
        return true;
    }
}