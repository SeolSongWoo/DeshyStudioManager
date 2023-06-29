import SignUpService from "./SignUpService.js";
import Util from "../util/Util.js";

export default class SignUpUI {

    constructor() {
        this.signupService = new SignUpService();
    }

    addSignupButtonClickEvent(element) {
        element.addEventListener('submit', this.#signupButtonClickEventHandler);
    }

    #signupButtonClickEventHandler = async (event) => {
        event.preventDefault();
        if(!Util.checkValidity(event)) return;
        const signupForm = document.querySelector('#signupForm');
        const signupData = this.#getSignupData(signupForm);
        const signupResult = await this.signupService.signUp(signupData);
        if(signupResult.status === 201) {
            alert('회원가입이 완료되었습니다.');
            location.href = '/login';
        } else if(signupResult.status === 400) {
            alert('잘못된 요청입니다.');
            return;
        } else {
            alert('회원가입에 실패하였습니다.잠시 후 다시 시도해주세요.');
            return;
        }
    }

    #getSignupData(signupForm) {
        const signupData = {};
        signupData.name = signupForm.memberName.value;
        signupData.email = signupForm.memberEmail.value;
        signupData.id = signupForm.memberId.value;
        signupData.password = signupForm.memberPassword.value;
        signupData.phone = signupForm.memberPhone.value;
        return signupData;
    }

}