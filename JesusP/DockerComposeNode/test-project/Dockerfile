FROM node:boron

# Create app directory
RUN mkdir -p /app
WORKDIR /app

# Bundle app source
COPY . /app

# Install app dependencies
RUN npm install

CMD ["npm", "start"]
