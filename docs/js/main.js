(function () {
  "use strict";

  var bar = document.querySelector(".topbar");
  var toTop = document.querySelector(".totop");
  var links = Array.prototype.slice.call(
    document.querySelectorAll(".topbar__nav a")
  );

  var sections = links
    .map(function (a) {
      return document.querySelector(a.getAttribute("href"));
    })
    .filter(Boolean);

  /* 스크롤이 시작되면 상단 바에 경계선 */
  function toggleBorder() {
    bar.classList.toggle("is-stuck", window.scrollY > 8);
  }

  /* 한 화면 이상 내려가면 버튼 생기게 */
  function toggleToTop() {
    if (!toTop) return;
    toTop.classList.toggle("is-shown", window.scrollY > window.innerHeight * 0.8);
  }

  /* 화면에 들어온 섹션의 메뉴를 표시 */
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
      toggleToTop();
      markActive();
      ticking = false;
    });
  }

  window.addEventListener("scroll", onScroll, { passive: true });
  onScroll();
})();
