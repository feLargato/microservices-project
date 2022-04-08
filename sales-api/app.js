import express from 'express';

import { connectDb } from './src/config/db/mongoDb.js';
import { createMockedData } from './src/config/db/mockedData.js';
import checkToken from './src/config/auth/checkToken.js'
import { connectMq } from './src/config/rabbitmq/rabbitConfig.js'

const app = express();
const env = process.env;
const PORT = env.PORT || 8082;

connectDb();
createMockedData();
connectMq();

app.use(checkToken);

app.get("/sales-api/status", (req, res) => {
        return res.status(200).json({
        service: "sales-api",
        status: "up",
        httpstatus: 200,
    })
});

app.listen(PORT, () => {
    console.info("Server is up on port 8082");
})