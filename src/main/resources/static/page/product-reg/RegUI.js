import ProductRegService from "./RegService.js";
import Util from "../util/Util.js";

export default class ProductRegUI {
    constructor() {
        this.productRegService = new ProductRegService();
    }

    addProductRegButtonClickEvent(formElement) {
        formElement.addEventListener('submit', this.#regButtonClickEventHandler);
    }

    #regButtonClickEventHandler = async(e) => {
        e.preventDefault();
        if(!Util.checkValidity(e)) return;
        const regData = this.#getRegData(e.target);
        const regResult = await this.productRegService.registration(regData);
        if(regResult.status === 201) {
            alert('상품등록이 완료되었습니다.');
        } else if(regResult.status === 409) {
            alert('해당 상품이 이미 존재합니다.');
        } else {
            alert('상품등록에 실패하였습니다.잠시 후 다시 시도해주세요.');
        }
    }

    #getRegData(target) {
        const regData = {};
        regData.prpProductName = target.prpProductName.value;
        regData.prpProductVendor = target.prpProductVendor.value;
        regData.prpProductOriginPrice = target.prpProductOriginPrice.value;
        regData.prpProductSize = target.prpProductSize.value;
        regData.prpProductQuantity = target.prpProductQuantity.value;
        regData.prpProductCategory = target.prpProductCategory.value;
        regData.prpRegDate = moment().format('YYYY-MM-DD');
        return regData;
    }

}