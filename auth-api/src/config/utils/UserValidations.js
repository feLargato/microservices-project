import UserException from "../../modules/user/exception/UserException.js"
import * as HttpStatus from "../utils/HttpStatus.js"
import bcrypt from "bcrypt"
import User from "../../modules/user/model/User.js";
import axios from "axios";

import { EMAIL_API_KEY } from "../utils/secrets.js";
import { EMAIL_API_URL } from "../utils/secrets.js";

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

    validateUserLoggedIn(user, authenticatedUser) {
        if(!authenticatedUser || user.id !== authenticatedUser.id) {
            throw new UserException(HttpStatus.FORBIDDEN, "You can only see your user data.");
        }
    }

    async validateUserEmailByExternalApi(email) {

        try {
            console.info(`Sending request to abstract's api to check validate user's email. 
            ${email}`)
        
            let response;

            await axios.get(`${EMAIL_API_URL}api_key=${EMAIL_API_KEY}&email=${email}`)
            .then(res => {
                response = res.data.is_valid_format.value;
            
                return response;
    
            })
            .catch((error) => {
                console.error(error.message);
                response = false;
            });

        }
        catch {
            return false;
        }

    }

}

export default new UserValidations();