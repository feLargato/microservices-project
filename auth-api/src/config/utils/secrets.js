const env = process.env;

export const EMAIL_API_KEY = "79553935aa9e44429a21039b160f00cb";
export const EMAIL_API_URL = "https://emailvalidation.abstractapi.com/v1/?"
export const API_SECRET = env.API_SECRET ? env.API_SECRET : "bWljcm9zc2Vydmljb3MtY29udGFpbmVyLXBhc3N3b3Jk";

export const DB_HOST = env.DB_HOST ? env.DB_HOST : "localhost";
export const DB_NAME = env.DB_NAME ? env.DB_NAME : "auth-db";
export const DB_USER = env.DB_USER ? env.DB_USER : "admin";
export const DB_PASSWORD = env.DB_PASSWORD ? env.DB_PASSWORD : "root";
export const DB_PORT = env.DB_PORT ? env.DB_DB_PORT : "5432";

