import UserRepository from "../repository/UserRepository.js";
import jwt from "jsonwebtoken";
import * as httpStatus from "../../../config/utils/HttpStatus.js"
import * as secret from "../../../config/utils/secrets.js";
import UserValidations from "../../../config/utils/UserValidations.js";
import UserException from "../exception/UserException.js";
import * as HttpStatus from "../../../config/utils/HttpStatus.js"

class UserService {

    async getAccessToken(req) {
        try {
            const { email, password } = req.body;
            UserValidations.validateAccessData(email, password);    
            let user = await UserRepository.findByEmail(email);
            UserValidations.validateUserNotFound(user);
            await UserValidations.validatePassword(password, user.password);
            let authenticatedUser = {id: user.id, name: user.name, email: user.email}
            const accesccToken = jwt.sign(
                {authenticatedUser},
                secret.API_SECRET,
                {expiresIn: '1d'}
            );
            return {
                status: httpStatus.OK,
                accesccToken,
            }

        } catch (error) {
            return {
                status: error.status ? error.status : httpStatus.INTERNAL_SERVER_ERROR,
                message: error.message,
            }            
        }       

    }

    async findByEmail(req) {
        try {
            const { email } = req.params;
            let { authenticatedUser } = req;
            UserValidations.validateEmail(email);
            let user = await UserRepository.findByEmail(email);
            UserValidations.validateUserNotFound(user);
            UserValidations.validateUserLoggedIn(user, authenticatedUser);
            return {
                status: httpStatus.OK,
                user: {
                    id: user.id,
                    name: user.name,
                    email: user.email,
                },
            };
        } catch (error) {
            return {
                status: error.status ? error.status : httpStatus.INTERNAL_SERVER_ERROR,
                message: error.message,
            }
        }
    }

    async create(req) {
        try {

            const { email } = req.body;
            const isValid = await UserValidations.validateUserEmailByExternalApi(email);
            let user;
            if(isValid){
                user = await UserRepository.create(req.body);        
            }
            else {
                throw new UserException(HttpStatus.NOT_ACCPTABLE, "Email has a invalid format");
            }
        
            return {
                status: httpStatus.OK,
                user: {
                    id: user.id,
                    name: user.name,
                    email: user.email,
                },
            };
        } catch (error) {
            return {
                status: error.status ? error.status : httpStatus.INTERNAL_SERVER_ERROR,
                message: error.message,
            }
        }
    }

}


export default new UserService();