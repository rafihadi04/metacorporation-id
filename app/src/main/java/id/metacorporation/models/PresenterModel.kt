package id.metacorporation.models

import id.metacorporation.enum.SosmedType

class PresenterModel(
    var nama: String = "",
    var usernameSosmed: String = "",
    var jenisSosmed : SosmedType = SosmedType.NULL,
    var deskripsiSosmed :String = "",
    var urlImage :String = "",
    var resourceImage :Int = 0
    )