import bcrypt from "bcrypt";
import User from "../../modules/user/model/User.js";

export async function createMockedData() {
    await User.sync({
        force: true
    });

    let mockedPassword = await bcrypt.hash("qwerty", 10);

    let firstUser = await User.create({
        name: "fernando",
        email: "emaildoFernando@gmail.com",
        password: mockedPassword, 
    });

}