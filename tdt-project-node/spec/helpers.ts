const encodeBase64 = (source) => Buffer.from(source).toString("base64");

export const authheader = (user, pass) =>
  `Basic ${encodeBase64(`${user}:${pass}`)}`;
