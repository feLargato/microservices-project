import express from 'express';

const app = express();
const env = process.env;

app.listen(8082, () => {
    console.info("Server is up on port 8082");
})