/**
 * User.js
 *
 * @description :: TODO: You might write a short summary of how this model works and what it represents here.
 * @docs        :: http://sailsjs.org/documentation/concepts/models-and-orm/models
 */

module.exports = {

  autoCreatedAt: 'created_at',

  autoUpdatedAt: 'updated_at',

  attributes: {

    name: {
      type: 'string',
      size: 100,
      required: true
    },

    username: {
      type: 'string',
      size: 100,
      required: true
    },

    email: {
      type: 'string',
      size: 100,
      required: true
    }

  }
};
