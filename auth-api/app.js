import express from "express";
import * as db from './src/config/db/mockedData.js';

const app = express();
const env = process.env;

db.createMockedData();

app.listen(8080, () => {
    console.info('Server started at port 8080')
});