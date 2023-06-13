import SignUpUI from "./SignUpUI.js";

const signupUI = new SignUpUI();
await signupUI.addSignupButtonClickEvent(document.getElementById('signupForm'));