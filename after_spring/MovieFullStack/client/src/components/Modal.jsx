const Modal = ({ buttonText, modalId, children }) => {
  return (
    <div>
      <button
        className="btn btn-secondary"
        onClick={() =>
          document.getElementById(`my-modal-${modalId}`).showModal()
        }
      >
        {buttonText}
      </button>
      <dialog id={`my-modal-${modalId}`} className="modal">
        <div className="modal-box">{children}</div>
        <form method="dialog" className="modal-backdrop">
          <button>close</button>
        </form>
      </dialog>
    </div>
  );
};

export default Modal;
