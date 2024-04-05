$('.sl').each(function() {
    var $list = $('<ul></ul>');
    var $options = $(this).find('select > option');
    
    var value, text;
    for (i = 0; i < $options.length; ++i) {
      value = $options.eq(i).attr('value');
      text = $options.eq(i).text();
      
      $list.append('<li data-value="' + value + '">' + text + '</li>');
    }
    
    $(this).prepend($list);
    
    // Toggles the active state of the `.sl` when the user clicks on it.
    var $currentSelect = $(this);
    var selectedText;
    var placeholderText = $currentSelect.find('.sl-holder').text();
    $currentSelect.find('label').click(function() {
      $(this).find('.sl-holder').text(placeholderText);
      if ($currentSelect.hasClass('active')) {
        $currentSelect.find('.sl-holder').text(selectedText);
        $currentSelect.removeClass('active');
      } else
        $currentSelect.addClass('active');
    });
    
    // Selects the `option` from the `select` when the user click on the corresponding item in the list.
    // Also hides the dropdown.
    $currentSelect.find('li').click(function(e) {
      var selectedValue = $(this).attr('data-value');
      selectedText = $(this).text();
      $currentSelect.find('.sl-holder').text(selectedText);
      $currentSelect.find('option[value=' + selectedValue + ']').prop('selected', true);
      $currentSelect.removeClass('active');
    });
    
    // Hides the dropdown if the user click on anywhere except the `select`.
    // Copy pasted this from Stack Overflow because I haven't understood how this works. Probably will do in the near future.
    $(document).click(function(e) {
      if ($(e.target).closest('.sl').length === 0) {
        $currentSelect.find('.sl-holder').text(selectedText);
        $currentSelect.removeClass('active');
      }
    });
  });