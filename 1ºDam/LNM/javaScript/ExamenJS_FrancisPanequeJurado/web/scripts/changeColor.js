
window.addEventListener('mouseover', function(evt) {
    if (evt.target.classList.contains('efectos')) {
      evt.target.style.color = 'yellow';
    }
  });

window.addEventListener('mouseout', function(evt) {
    if (evt.target.classList.contains('efectos')) {
      evt.target.style.color = 'white';
    }
  });

  