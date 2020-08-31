<style>
  /** { box-sizing: border-box; }*/
  /*body {*/
  /*  margin: 0;*/
  /*  background: radial-gradient(#BFD6E2 1px, rgba(255,255,255,0) 2px);*/
  /*  background-size: 10px 10px;*/
  /*}*/
 .navmenu{
   width: 100%;
 }
  .navmenu ul {
    list-style: none;
    margin: 0;
    padding: 0;
  }
  .navmenu a {
    display: block;
    text-decoration: none;
    outline: none;
    transition: .4s ease-in-out;
  }
  .topmenu {
    backface-visibility: hidden;
    background: rgba(255,255,255,.8);
  }
  .topmenu > li {
    display: inline-block;
    position: relative;
  }
  .topmenu > li > a {
    font-family: 'Exo 2', sans-serif;
    height: 10px;
    line-height: 70px;
    padding: 0 10px;
    font-weight: bold;
    color: #003559;
    text-transform: uppercase;
  }
  .down:after {
    content: "\f107";
    margin-left: 8px;
    font-family: FontAwesome;
  }
  .topmenu li a:hover { color: #E6855F; }
  .submenu {
    background: white;
    border: 2px solid #003559;
    position: absolute;
    left: 0;
    visibility: hidden;
    opacity: 0;
    z-index: 5;
    width: 150px;
    transform: perspective(600px) rotateX(-90deg);
    transform-origin: 0% 0%;
    transition: .6s ease-in-out;
  }
  .topmenu > li:hover .submenu{
    visibility: visible;
    opacity: 1;
    transform: perspective(600px) rotateX(0deg);
  }
  .submenu li a {
    color: #7f7f7f;
    font-size: 13px;
    line-height: 36px;
    padding: 0 25px;
    font-family: 'Kurale', serif;
  }
</style>
<nav class="navmenu">
  <ul class="topmenu">
    <#list categories as category>
    <li><a href="">${category.category_name}</a>
      <ul class="submenu">
        <#list dopcategories as dopcategory>
          <li><a href="">${dopcategory.name}</a></li>
        </#list>
      </ul>
    </li>

    </#list>

  </ul>
</nav>
