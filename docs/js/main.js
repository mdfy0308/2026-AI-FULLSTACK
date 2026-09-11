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

  /* ── 모달 열기 / 닫기 ── */
  var body = document.body;

  function openModal(id) {
    var modal = document.getElementById(id);
    if (!modal) return;
    modal.classList.add("is-open");
    modal.setAttribute("aria-hidden", "false");
    body.classList.add("modal-locked");

    /* 패널 안 스크롤 초기화 */
    var scrollArea = modal.querySelector(".modal__body");
    if (scrollArea) scrollArea.scrollTop = 0;
  }

  function closeModal(modal) {
    modal.classList.remove("is-open");
    modal.setAttribute("aria-hidden", "true");
    body.classList.remove("modal-locked");
  }

  /* 버튼 클릭 → 열기 */
  document.addEventListener("click", function (e) {
    var trigger = e.target.closest("[data-modal]");
    if (trigger) {
      openModal(trigger.getAttribute("data-modal"));
      return;
    }

    /* X 버튼 → 닫기 */
    var closeBtn = e.target.closest(".modal__close");
    if (closeBtn) {
      closeModal(closeBtn.closest(".modal"));
      return;
    }

    /* 배경 클릭 → 닫기 */
    var backdrop = e.target.closest(".modal__backdrop");
    if (backdrop) {
      closeModal(backdrop.closest(".modal"));
    }
  });

  /* ESC 키 → 닫기 */
  document.addEventListener("keydown", function (e) {
    if (e.key === "Escape") {
      var open = document.querySelector(".modal.is-open");
      if (open) closeModal(open);
    }
  });
})();
