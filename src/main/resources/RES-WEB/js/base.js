/**
 * Base functions.
 */
var Base = function() {
  return {
    /**
     * Show notification.
     */
    growl: function(message, opt_type) {
      $.bootstrapGrowl('<p>' + message + '</p>', {
        ele: 'body',
        type: opt_type || 'info',
        offset: {from: 'top', amount: 60},
        align: 'right',
        //width: 'auto',
        delay: 3000,
        allow_dismiss: true,
        stackup_spacing: 10
      });
    }
  };
}();

$(function() {
});