import express from 'express';

import { connectDb } from './src/config/db/mongoDb.js';
import { createMockedData } from './src/config/db/mockedData.js';
import checkToken from './src/config/auth/checkToken.js'
import { connectMq } from './src/config/rabbitmq/rabbitConfig.js'
import { sendMessageToProductStockUpdateQueue } from './src/modules/products/rabbitMq/ProductStockUpdateSender.js';
import salesRoutes from "./src/modules/sales/routes/SaleRoutes.js";
const app = express();
const env = process.env;
const PORT = env.PORT || 8082;

connectDb();
//createMockedData();
connectMq();

app.use(express.json());
app.use(checkToken);

app.use(salesRoutes);
app.get("/test", (req, res) => {
    try {
        sendMessageToProductStockUpdateQueue([
            {
                productId: 100,
                quantity: 2
            },
            {
                productId: 200,
                quantity: 2
            },
            {
                productId: 300,
                quantity: 2
            }
        ]);
        return res.status(200).json({
            status: 200
        });
    } catch (error) {
        console.log(error)
    }

})
app.get("/sales-api", (req, res) => {
        return res.status(200).json({
        service: "sales-api",
        status: "up",
        httpstatus: 200,
    })
});

app.listen(PORT, () => {
    console.info("Server is up on port 8082");
})