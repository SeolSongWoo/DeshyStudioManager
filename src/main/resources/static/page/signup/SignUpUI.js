import SignUpService from "./SignUpService.js";

export default class SignUpUI {

    constructor() {
        this.signupService = new SignUpService();
    }

    async addSignupButtonClickEvent(element) {
        element.addEventListener('submit', this.#signupButtonClickEventHandler);
    }

    #signupButtonClickEventHandler = async (event) => {
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
        signupData.memberName = signupForm.memberName.value;
        signupData.memberEmail = signupForm.memberEmail.value;
        signupData.memberId = signupForm.memberId.value;
        signupData.memberPassword = signupForm.memberPassword.value;
        signupData.memberPhoneNumber = signupForm.memberPhoneNumber.value;
        return signupData;
    }
}