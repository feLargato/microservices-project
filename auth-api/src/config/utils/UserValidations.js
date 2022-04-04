import UserException from "../../modules/user/exception/UserException.js"
import * as HttpStatus from "../utils/HttpStatus.js"
import bcrypt from "bcrypt"


class UserValidations {

    validateEmail(email) {
        if(!email) {
            throw new UserException(
                HttpStatus.BAD_REQUEST ,
                "Email not informed");
        }
    }

    validateUserNotFound(user) {
        if(!user) {
            throw new UserException(HttpStatus.BAD_REQUEST, "User not found");
        }
    }

    validateAccessData(email, password) {
        if(!email || !password) {
            throw new UserException(HttpStatus.UNAUTHORIZED, "Email and password must be informed.");
        }
    }

    async validatePassword(password, encriptedPassword) {
        if(!await bcrypt.compare(password, encriptedPassword)) {
            throw new UserException(HttpStatus.UNAUTHORIZED, "Wrong password");
        }
    }

}

export default new UserValidations();