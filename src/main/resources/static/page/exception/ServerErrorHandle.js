export default class ServerErrorHandle {

    static checkResponseStatus(response) {
        if(response.status === 200) {
            return response.data;
        }
        else {
            location.href = "/server-error"
        }
    }

}