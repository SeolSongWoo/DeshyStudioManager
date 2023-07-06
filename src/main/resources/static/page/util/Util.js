export default class Util {

    static checkValidity(event) {
        if (!event.target.checkValidity()) {
            event.stopPropagation();
            event.target.classList.add('was-validated');
            return false;
        }
        return true;
    }
}