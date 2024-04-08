let tiempoRespuesta = setTimeout(()=>{
    if (!confirm("Le gusta la página")){
      window.open("https://fpiespablopicasso.es/");
    }
  }, 30000);