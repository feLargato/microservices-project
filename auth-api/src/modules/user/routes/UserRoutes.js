import { Router } from "express";
import UserController from "../controller/UserController.js";
import checkToken from "../../../config/auth/checkToken.js";

const router = new Router();


/**
 * @swagger
 * /auth/user/token:
 *  post:
 *    description: Use to authenticate an user
 *    responses:
 *       '200':
 *          description: Ok
 */
router.post("/auth/user/token", UserController.getAccessToken);

router.use(checkToken);

/**
 * @swagger
 * /auth/user/email/:email:
 *  get:
 *    description: Use to return a user
 *    responses:
 *       '200':
 *          description: returns a user
 *    parameters:
 *        - in: path
 *          name: email
 *          type: string
 *          required: true
 *          description: user email  
 *        - in: header
 *          name: Authorization
 *          type: string
 *          required: true
 */
router.get("/auth/user/email/:email", UserController.findByEmail);

/**
 * @swagger
 * /auth/user/create:
 *  post:
 *    description: creates an user
 *    responses:
 *       '200':
 *          description: return created user
 *    parameters:
 *       - in: body
 *         name: user
 *         description: The user to create.
 *         schema:
 *           type: object
 *           required:
 *             - user
 *           properties:
 *             password:
 *               type: string
 *             email:
 *               type: string
 *             name:
 *               type: string
 *       - in: header
 *         name: Authorization
 *         type: string
 *         required: true 
 */
router.post("/auth/user/create/", UserController.create);


export default router;