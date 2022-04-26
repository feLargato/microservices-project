import express from "express";
import { createMockedData } from './src/config/db/mockedData.js';
import userRoutes from "./src/modules/user/routes/UserRoutes.js";
import swaggerJsDoc from "swagger-jsdoc";
import swaggerUi from "swagger-ui-express";
const app = express();
const env = process.env;
const PORT = env.PORT || 8080;
const CONTAINER_ENV = "container";



const swaggerOptions = {
    swaggerDefinition: {
        info: {
            title: 'auth-api',
            description: 'Authentication api',
            contact: {
                name: "lfrsantos05@gmail.com"
            },
            servers: ["http://localhost:8080"]
        }
    },
    apis: ["app.js", "./src/modules/user/routes/*.js"]
}
const swaggerDocs = swaggerJsDoc(swaggerOptions);

app.use("/auth/docs", swaggerUi.serve, swaggerUi.setup(swaggerDocs))


app.get("/auth", (req, res) => {
    return res.status(200).json({
      service: "Auth-API",
      status: "up",
      httpStatus: 200,
   });
});

app.use(express.json());


startApplication();
function startApplication() {
    if(env.NODE_ENV !== CONTAINER_ENV) {
        createMockedData();
    }
}

app.get("/auth/create/mocked-data", (req, res) => {
    createMockedData();
    return res.json({message: "data created"})
})

app.use(userRoutes);

app.listen(PORT, () => {
    console.info(`Server started at port ${PORT}`);
});
