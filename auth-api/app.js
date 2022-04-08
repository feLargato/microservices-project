import express from "express";
import * as db from './src/config/db/mockedData.js';
import userRoutes from "./src/modules/user/routes/UserRoutes.js"
const app = express();
const env = process.env;
const PORT = env.PORT || 8080;
const CONTAINER_ENV = "container";

app.use(express.json());


startApplication();
function startApplication() {
    if(env.NODE_ENV !== CONTAINER_ENV) {
        db.createMockedData();
    }
}

app.get("/auth", (req, res) => {
    return res.status(200).json({
      service: "Auth-API",
      status: "up",
      httpStatus: 200,
   });
});

app.get("/auth/create/mocked-data", (req, res) => {
    db.createMockedData();
    return res.json({message: "data created"})
})

app.use(userRoutes);

app.listen(PORT, () => {
    console.info(`Server started at port ${PORT}`);
});
