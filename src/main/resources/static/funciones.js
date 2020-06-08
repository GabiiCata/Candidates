function deleteCandidate ( id )
{
	swal({
		title: "¿Está seguro de eliminar el candidato?",
		icon: "warning",
		buttons: true,
		dangerMode: true,
	})
		.then((deleteOK) => {
			if (deleteOK) {
				$.ajax({
					url: "/delete/" + id,
					success: function (res) {
						console.log(res);
					}
				});
				swal("Candidato eliminado con éxito", {
					icon: "success",
				}).then((ok) => {
					if (ok) {
						location.href = "/list";
					}
				});
			} else {
				swal("Operacion cancelada !");
			}
		});
}