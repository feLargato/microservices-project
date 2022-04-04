import { Router } from "express";
import UserController from "../controller/UserController.js";

const router = new Router();

router.get("/auth/user/email/:email", UserController.findByEmail);
router.post("/auth/user/token", UserController.getAccessToken);

export default router;