FROM node:boron

COPY index.js index.js

COPY entrypoint_01.sh /usr/local/bin
COPY entrypoint_02.sh /usr/local/bin

ENTRYPOINT ["entrypoint_01.sh","entrypoint_02.sh"]

CMD ["node","index.js"]
