import { Router } from "express";

import SalesController from "../controller/SalesController.js";

const router = new Router();


/**
 * @swagger
 *  /sales-api/sale/:
 *  get:
 *    description: returns all the sales' registers
 *    responses:
 *       '200':
 *          description: Ok
 */
router.get("/sales-api/sale/", SalesController.findAll);

/**
 * @swagger
 *  /sales-api/sale/product/:productId:
 *  get:
 *    description: returns a sale by its product id
 *    responses:
 *       '200':
 *          description: Ok
 *    parameters:
 *        - in: path
 *          name: productId
 *          type: numeric
 *          required: true
 *          description: product id  
 */
router.get("/sales-api/sale/product/:productId", SalesController.findByProductId);

/**
 * @swagger
 *  /sales-api/sale/:id:
 *  get:
 *    description: returns a sale by its id
 *    responses:
 *       '200':
 *          description: Ok
 *    parameters:
 *        - in: path
 *          name: id
 *          type: numeric
 *          required: true
 *          description: sale id  
 */
router.get("/sales-api/sale/:id", SalesController.findById);

/**
 * @swagger
 *  /sales-api/sale/create:
 *  post:
 *    description: creates a sale
 *    responses:
 *       '200':
 *          description: returns created sale
 *    parameters:
 *       - in: body
 *         name: sale
 *         description: The sale to create.
 *         schema:
 *           type: object
 *           required:
 *             - sale
 *           properties:
 *             products:
 *               type: array
 *             user:
 *               type: object
 *             status:
 *               type: string
 *       - in: header
 *         name: Authorization
 *         type: string
 *         required: true 
 */
router.post("/sales-api/sale/create", SalesController.createSale);

export default router;