function createRainbowAnimation() {
    const colors = ['red', 'orange', 'yellow', 'green', 'blue', 'indigo', 'violet'];
    let index = 0;
    const span = document.getElementById('rainbow-text');

    function updateColor() {
        span.style.background = `linear-gradient(45deg, ${colors.join(', ')})`;
        span.style.backgroundSize = '200% 200%';
        span.style.backgroundClip = 'text';
        span.style.webkitBackgroundClip = 'text';
        span.style.webkitTextFillColor = 'transparent';
        
        index = (index + 1) % colors.length;
        span.style.backgroundPosition = `${index * 100}% ${index * 100}%`;
    }

    setInterval(updateColor, 100); // Cambia el color cada 100ms
}

document.addEventListener('DOMContentLoaded', createRainbowAnimation);

  