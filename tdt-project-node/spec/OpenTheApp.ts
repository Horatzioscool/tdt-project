import { Ensure, startsWith } from "@serenity-js/assertions";
import { Task } from "@serenity-js/core";
import { Navigate, Website } from "@serenity-js/protractor";
import * as config from "../config.json";

const { url, username, password } = config;

export const OpenTheApp = () => Task.where("#actor opens the app");
