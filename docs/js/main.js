(function () {
  "use strict";

  var bar = document.querySelector(".topbar");
  var links = Array.prototype.slice.call(
    document.querySelectorAll(".topbar__nav a")
  );
  var sections = links
    .map(function (a) {
      return document.querySelector(a.getAttribute("href"));
    })
    .filter(Boolean);

  /* 스크롤이 시작되면 상단 바에 경계선을 그린다 */
  function toggleBorder() {
    bar.classList.toggle("is-stuck", window.scrollY > 8);
  }

  /* 화면에 들어온 섹션의 메뉴를 표시한다 */
  function markActive() {
    var mid = window.innerHeight * 0.35;
    var current = null;

    sections.forEach(function (el) {
      if (el.getBoundingClientRect().top <= mid) current = el.id;
    });

    links.forEach(function (a) {
      a.classList.toggle(
        "is-active",
        current !== null && a.getAttribute("href") === "#" + current
      );
    });
  }

  var ticking = false;
  function onScroll() {
    if (ticking) return;
    ticking = true;
    window.requestAnimationFrame(function () {
      toggleBorder();
      markActive();
      ticking = false;
    });
  }

  window.addEventListener("scroll", onScroll, { passive: true });
  onScroll();
})();
