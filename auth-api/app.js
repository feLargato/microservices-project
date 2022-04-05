import express from "express";
import * as db from './src/config/db/mockedData.js';
import userRoutes from "./src/modules/user/routes/UserRoutes.js"
const app = express();

app.use(express.json());
db.createMockedData();

app.get("/auth", (req, res) => {
    return res.status(200).json({
      service: "Auth-API",
      status: "up",
      httpStatus: 200,
   });
});

app.use(userRoutes);

app.listen(8080, () => {
    console.info('Server started at port 8080')
});
