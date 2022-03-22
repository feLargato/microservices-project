import express from "express";

const app = express();
const env = process.env;

app.listen(8080, () => {
    console.info('Server started at port 8080')
});