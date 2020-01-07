package reclipe

object Main extends App {
  println(
    """
      |<p>Drag this to your bookmark bar:</p>
      |<a href="javascript: (function () {
      |    let code = document.createElement('script');
      |    code.setAttribute('src', 'https://jakehschwartz.github.io/reclipe/scripts/scraper.js');
      |    code.setAttribute('type', 'text/javascript');
      |    document.body.appendChild(code);
      |
      |    let execute = document.createElement('script');
      |    execute.setAttribute('src', 'https://jakehschwartz.github.io/reclipe/scripts/launcher.js');
      |    code.setAttribute('type', 'text/javascript');
      |    document.body.appendChild(execute);
      | }());">Scraper</a>
      |""".stripMargin.trim
  )
}
